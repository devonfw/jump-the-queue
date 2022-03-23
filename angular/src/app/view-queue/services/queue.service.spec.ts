import { HttpClientTestingModule } from "@angular/common/http/testing";
import { TestBed } from "@angular/core/testing";
import { RouterTestingModule } from "@angular/router/testing";
import { QueueService } from "./queue.service";

describe("QueueService", () => {
  beforeEach(() =>
    TestBed.configureTestingModule({
      imports: [RouterTestingModule, HttpClientTestingModule],
    })
  );

  it("should be created", () => {
    const service: QueueService = TestBed.inject(QueueService);
    expect(service).toBeTruthy();
  });
});
